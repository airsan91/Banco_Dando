package ucentral.edu.co.appBanco.servicios;



import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ucentral.edu.co.appBanco.dto.UsuarioDto;
import ucentral.edu.co.appBanco.entidades.Usuario;
import ucentral.edu.co.appBanco.operaciones.OperacionesUsuario;
import ucentral.edu.co.appBanco.repositorios.RepositorioUsuario;


@Service
@AllArgsConstructor
public class ServicioUsuario implements OperacionesUsuario {


    private ModelMapper modelMapper = new ModelMapper();

    private final RepositorioUsuario repoUsuario;

    public UsuarioDto crear(UsuarioDto usuarioDto) {

            Usuario elUsuario = repoUsuario.save(modelMapper.map(usuarioDto, Usuario.class));
            return modelMapper.map(elUsuario, UsuarioDto.class);
        }
    }

