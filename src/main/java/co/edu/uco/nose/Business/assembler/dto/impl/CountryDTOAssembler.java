package co.edu.uco.nose.Business.assembler.dto.impl;

import co.edu.uco.nose.Business.Domain.CountryDomain;
import co.edu.uco.nose.Business.assembler.dto.DTOassembler;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.CountryDTO;

import java.util.List;

public final class CountryDTOAssembler implements DTOassembler<CountryDTO, CountryDomain> {

    // Instancia única (patrón Singleton)
    private static final DTOassembler<CountryDTO, CountryDomain> instance = new CountryDTOAssembler();

    // Constructor privado para evitar instanciación directa
    private CountryDTOAssembler() { }

    // Método público estático que retorna la instancia única
    public static DTOassembler<CountryDTO, CountryDomain> getCountryDTOAssembler() {
        return instance;
    }

    @Override
    public CountryDTO toDTO(final CountryDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new CountryDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new CountryDTO(domainTmp.getId(),domainTmp.getName());
    }

    @Override
    public CountryDomain toDomain(final CountryDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new CountryDTO());
        return new CountryDomain(dtoTmp.getId(), dtoTmp.getName());
    }

    @Override
    public List<CountryDTO> toDTO(List<CountryDomain> domainList) {
        return List.of();
    }
}
