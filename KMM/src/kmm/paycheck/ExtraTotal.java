/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author adrianohrl
 */
@Entity
public class ExtraTotal implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long code;
    private float extraTotal;
    @OneToOne
    private Extra extra;

    public ExtraTotal() {
    }

    public ExtraTotal(float extraTotal, Extra extra) {
        this.extraTotal = extraTotal;
        this.extra = extra;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public float getExtraTotal() {
        return extraTotal;
    }

    public void setExtraTotal(float extraTotal) {
        this.extraTotal = extraTotal;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }
    
}
