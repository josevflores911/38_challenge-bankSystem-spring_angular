package com.tokyo.wayon.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

@Entity(name = "Users")
@Table(name = "users")
@Getter
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String name;

    @Size(min = 12, max = 12, message = "{validation.name.size}")
    private BigInteger account;

    private BigDecimal amount;

    private int userkey;

    @Transient
    private boolean active;

    public User(UserData data){
        this.name=data.name();
        this.account=data.account();
        this.amount=data.amount();
        this.userkey=data.userkey();
    }

    public void update(UserDetail data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.account().bitLength()==12 ) {
            this.account = data.account();
        }

        if (!data.amount().equals(0) ) {
            this.amount = data.amount();
        }
//        if (datos.direccion() != null) {
//            this.direccion.actualizarDireccion(datos.direccion());
//        }
    }

    public void setAmount(BigDecimal amount) {
        if(this.amount.doubleValue()>0 && this.amount.doubleValue()>amount.intValue()){
            this.amount = this.amount.subtract(amount);
        }
    }

    public void delete() {
        this.active = false;
    }
}
