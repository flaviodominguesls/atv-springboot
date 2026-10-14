package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import biblioteca.biblioteca.Model.Livro;
import biblioteca.biblioteca.Repository.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LivroCrudPadraoService implements LivroCrudService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    LivroRepository livroRepository;

    @Override
    public LivroResponseDto criarLivro(LivroPostPutDto livroPostPutDto) {
        Livro livro = modelMapper.map(livroPostPutDto, Livro.class);
        return modelMapper.map(livroRepository.save(livro), LivroResponseDto.class);
    }

    @Override
    public List<LivroResponseDto> buscarTodosLivros() {
        return livroRepository.findAll()
                .stream()
                .map(livro -> modelMapper.map(livro, LivroResponseDto.class))
                .toList();
    }

    @Override
    public LivroResponseDto buscarLivroPorISBN(Long isbn) {
        return modelMapper.map(obterLivroExistentePorISBN(isbn), LivroResponseDto.class);
    }

    @Override
    public LivroResponseDto buscarLivroPorTitulo(String titulo) {
        return modelMapper.map(obterLivroExistentePorTitulo(titulo), LivroResponseDto.class);
    }

    @Override
    public LivroResponseDto atualizarLivro(Long isbn, LivroPostPutDto livroPostPutDto) {
        Livro livro = obterAutorExistente(isbn);
        livro.setAutorLivro(livroPostPutDto.getAutorLivro());
        livro.setAnoLivro(livroPostPutDto.getAnoLivro());
        livro.setEdicaoLivro(livroPostPutDto.getEdicaoLivro());
        livro.setTituloLivro(livroPostPutDto.getTituloLivro());
        return modelMapper.map(livroRepository.save(livro), LivroResponseDto.class);
    }

    @Override
    public void removerLivro(Long isbn) {
        // delete(entidade) permite que o cascade da relação remova também os livros do autor
        livroRepository.delete(obterLivroExistente(isbn));
    }

    // id inexistente = 404
    private Livro obterLivroExistentePorISBN(Long isbn) {
        return livroRepository.findById(isbn)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
    }

// id inexistente = 404
    private Livro obterLivroExistentePorTitulo(String titulo) {
        return livroRepository.findAll()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
    }

}