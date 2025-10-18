package co.edu.uco.nose.Business.entity;

public interface EntityAssambler <E, D>{

    E toEntity(D domain);
    D toDomain(E entity);
}
