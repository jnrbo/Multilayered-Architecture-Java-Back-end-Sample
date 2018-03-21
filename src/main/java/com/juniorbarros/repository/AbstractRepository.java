package com.juniorbarros.repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import com.juniorbarros.model.AbstractEntity;
import com.juniorbarros.model.Assert;
import com.juniorbarros.model.AttrVal;
import com.juniorbarros.model.AttrsVals;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by juniorbarros on 03/05/2016.
 */

public abstract class AbstractRepository<E extends AbstractEntity> {

    private final static String NOT_FOUND_MESSAGE = "Não encontrado";

    @Transactional
    public E save(E entity) {
        getCurrentSession().save(entity);
        return entity;
    }

    @Transactional(readOnly = true)
    public E findById(Long id) {
        E entity = getCurrentSession().get(getEntityType(), id);
        Assert.notNull(entity, NOT_FOUND_MESSAGE);
        return entity;
    }

    @Transactional(readOnly = true)
    public List<E> find(AttrsVals attrsValues) {
        return createCriteriaWithEqualsRestrictions(attrsValues).list();
    }

    @Transactional(readOnly = true)
    public E findUnique(AttrsVals attrsValues) {
        return (E)createCriteriaWithEqualsRestrictions(attrsValues).uniqueResult();
    }

    @Transactional(readOnly = true)
    public Long count() {
        return (Long)createEntityCriteria().setProjection(Projections.count("id")).uniqueResult();
    }

    @Transactional(readOnly = true)
    public List<E> listAll() {
        return createEntityCriteria().list();
    }

    private Criteria createCriteriaWithEqualsRestrictions(AttrsVals attrsValues) {
        Criteria criteria = createEntityCriteria();
        for (AttrVal attrValue : attrsValues.getList()) {
            criteria.add(Restrictions.eq(attrValue.getAttribute(), attrValue.getValue()));
        }
        return criteria;
    }

    protected Criteria createEntityCriteria() {
        Criteria criteria = getCurrentSession().createCriteria(getEntityType());
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        criteria.setFlushMode(FlushMode.MANUAL);
        return criteria;
    }

    private Class<E> getEntityType() {
        ParameterizedType type = (ParameterizedType)getClass().getGenericSuperclass();
        return (Class<E>)type.getActualTypeArguments()[0];
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Resource
    private SessionFactory sessionFactory;
}