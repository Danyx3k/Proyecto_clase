package co.edu.uco.nose.Business.assembler.dto;

public interface DTOassembler <T, D>{

    T toDTO (D domain);
    D toDomain(T dto);
}
