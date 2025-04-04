package net.xeill.elpuig.veterinario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.xeill.elpuig.veterinario.repositories.UsuarioRepository;
import net.xeill.elpuig.veterinario.model.UsuarioModel;
import net.xeill.elpuig.veterinario.model.MascotaModel;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Agregar un usuario
    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        // Verificamos si ya existe un usuario con el mismo email
        UsuarioModel usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente != null) {
            // Si ya existe, no lo agregamos y retornamos null o lanzamos una excepción
            return null;
        }

        // Si el email no existe, guardamos el usuario
        return usuarioRepository.save(usuario);
    }

    // Obtener un usuario por su id
    public UsuarioModel obtenerUsuarioPorId(String id) {
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null); // Retorna el usuario si lo encuentra, sino null
    }

    // Obtener todos los usuarios
    public List<UsuarioModel> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    // Actualizar un usuario por su id
    public UsuarioModel editarUsuarioPorId(String id, UsuarioModel usuarioActualizado) {
        Optional<UsuarioModel> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            UsuarioModel usuario = usuarioExistente.get();

            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setApellido(usuarioActualizado.getApellido());
            usuario.setEmail(usuarioActualizado.getEmail());
            usuario.setNumeroCuenta(usuarioActualizado.getNumeroCuenta());

            // Solo actualizar la lista de mascotas si se proporciona en la solicitud
            if (usuarioActualizado.getMascotas() != null) {
                usuario.setMascotas(usuarioActualizado.getMascotas());
            }

            return usuarioRepository.save(usuario);
        } else {
            return null;
        }
    }

    // Eliminar un usuario por su id
    public void eliminarUsuarioPorId(String id) {
        usuarioRepository.deleteById(id);
    }

    // Agregar una mascota a un usuario
    public UsuarioModel agregarMascota(String id, MascotaModel mascota) {
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuario.get().getMascotas().add(mascota);
            return usuarioRepository.save(usuario.get());
        }
        return null;
    }

    // Obtener todas las mascotas de un usuario
    public List<MascotaModel> obtenerMascotasDeUsuario(String id) {
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        return (usuario.isPresent()) ? usuario.get().getMascotas() : null;
    }

    // Editar una mascota por su ID
    public UsuarioModel editarMascota(String usuarioId, String mascotaId, MascotaModel mascotaActualizada) {
        Optional<UsuarioModel> usuarioOpt = usuarioRepository.findById(usuarioId);
        if (usuarioOpt.isPresent()) {
            UsuarioModel usuario = usuarioOpt.get();

            // Buscar la mascota por ID y actualizar sus datos
            for (MascotaModel mascota : usuario.getMascotas()) {
                if (mascota.getId().equals(mascotaId)) {
                    mascota.setNombre(mascotaActualizada.getNombre());
                    mascota.setRaza(mascotaActualizada.getRaza());
                    mascota.setGenero(mascotaActualizada.getGenero());
                    mascota.setFechaNacimiento(mascotaActualizada.getFechaNacimiento());
                    mascota.setPeso(mascotaActualizada.getPeso());
                    break;
                }
            }

            // Guardar el usuario con la mascota actualizada
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    // Eliminar una mascota por ID
    public UsuarioModel eliminarMascota(String usuarioId, String mascotaId) {
        Optional<UsuarioModel> usuarioOpt = usuarioRepository.findById(usuarioId);
        if (usuarioOpt.isPresent()) {
            UsuarioModel usuario = usuarioOpt.get();

            // Filtrar y eliminar la mascota por ID
            usuario.getMascotas().removeIf(mascota -> mascota.getId().equals(mascotaId));

            // Guardar cambios y devolver el usuario actualizado
            return usuarioRepository.save(usuario);
        }
        return null;
    }
}
