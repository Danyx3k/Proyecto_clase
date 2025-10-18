package co.edu.uco.nose.Business.entity;

import java.util.List;

public interface EntityAssambler <E, D>{

    E toEntity(D domain);
    D toDomain(E entity);

    List<E> toDomain (List<D> entityList);

}
