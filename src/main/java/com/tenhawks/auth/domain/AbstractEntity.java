package com.tenhawks.auth.domain;

import com.tenhawks.auth.bean.AuthHelper;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


/**
 * Created by mukhtiar on 5/12/2018.
 */
@Data
@MappedSuperclass
public class AbstractEntity implements Serializable {

    @Id
    private String id;

    protected AbstractEntity() {
        this.id = AuthHelper.getUniqueKey();
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return Boolean.TRUE;
        if (obj == null)
            return Boolean.FALSE;
        if (obj instanceof AbstractEntity) {
            AbstractEntity other = (AbstractEntity) obj;
            return getId().equals(other.getId());
        } else {
            return Boolean.FALSE;
        }

    }
}
