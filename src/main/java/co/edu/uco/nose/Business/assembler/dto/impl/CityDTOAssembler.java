package co.edu.uco.nose.Business.assembler.dto.impl;

import co.edu.uco.nose.Business.Domain.CityDomain;
import co.edu.uco.nose.Business.assembler.dto.DTOassembler;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.CityDTO;


import java.util.List;

import static co.edu.uco.nose.Business.assembler.dto.impl.StateDTOAssembler.getStateDTOAssembler;

public final class CityDTOAssembler implements DTOassembler<CityDTO, CityDomain> {
    // ✅ Instancia única (Singleton)
    private static final DTOassembler<CityDTO, CityDomain> instance = new CityDTOAssembler();

    // 🚫 Constructor privado
    private CityDTOAssembler() { }

    // ✅ Método de acceso público a la instancia
    public static DTOassembler<CityDTO, CityDomain> getCityDTOAssembler() {
        return instance;
    }

    @Override
    public CityDTO toDTO(final CityDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new CityDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var stateDtoTmp = getStateDTOAssembler().toDTO(domainTmp.getState());
        return new CityDTO(domainTmp.getId(),domainTmp.getName(), stateDtoTmp);
    }

    @Override
    public CityDomain toDomain(final CityDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new CityDTO());
        var stateDomainTmp = getStateDTOAssembler().toDomain(dtoTmp.getState());
        return new CityDomain(dtoTmp.getId(),dtoTmp.getName(),stateDomainTmp);
    }

    @Override
    public List<CityDTO> toDTO(List<CityDomain> domainList) {
        return List.of();
    }
}
