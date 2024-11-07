package co.edu.ufps.servicies;

import co.edu.ufps.entities.Resultado;
import co.edu.ufps.repositories.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadoService {

    @Autowired
    private ResultadoRepository resultadoRepository;

    public List<Resultado> getAllResultados() {
        return resultadoRepository.findAll();
    }

    public Resultado getResultado(Long id) {
        return resultadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resultado no encontrado"));
    }

    public Resultado createResultado(Resultado resultado) {
        return resultadoRepository.save(resultado);
    }

    public Resultado updateResultado(Long id, Resultado resultado) {
        resultado.setId(id);
        return resultadoRepository.save(resultado);
    }

    public void deleteResultado(Long id) {
        resultadoRepository.deleteById(id);
    }
}


