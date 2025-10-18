package co.edu.uco.nose.Business.assembler.dto;

import java.util.List;

public interface DTOassembler <T, D>{

    T toDTO (D domain);
    D toDomain(T dto);

    List<T> toDTO (List<D> domainList);

}
