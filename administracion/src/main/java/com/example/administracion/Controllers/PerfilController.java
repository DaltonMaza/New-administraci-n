package com.example.administracion.Controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.administracion.Models.Asistencia;
import com.example.administracion.Services.AsistenciaService;
import com.example.administracion.Services.EmpleadoService;
import com.example.administracion.Services.HorarioService;
import com.example.administracion.Services.PersonaService;
import com.example.administracion.Services.TrabajadorService;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    TrabajadorService trabajadorService;
    @Autowired
    PersonaService personaService;
    @Autowired
    AsistenciaService asistenciaService;
    @Autowired
    HorarioService horarioService;

    @GetMapping("/{id}")
    public Map<String, Object> getTrabajador(@PathVariable("id") Long id) {
        // TODO investigar como mandar un mensaje si no se encuentra el empleado
        return trabajadorService.getTrabajadorInfo(id);
    }

    @GetMapping("/{id}/asistencias")
    public ArrayList<Asistencia> getAsistenciaByIdTrabajador(@PathVariable("id") Long idTrabajador) {
        return asistenciaService.getAsistenciasByIdTrabajador(idTrabajador);
    }

    @GetMapping("/{id}/horario")
    public Map<String, Object> getHorarioPorIdTrabajador(@PathVariable("id") Long idTrabajador) {
        Long idHorario = trabajadorService.getTrabajadorById(idTrabajador).getIdHorario();
        return horarioService.getFullHorarioById(idHorario);
    }
}
