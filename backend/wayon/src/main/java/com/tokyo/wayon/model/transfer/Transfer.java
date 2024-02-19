package com.tokyo.wayon.model.transfer;

import com.tokyo.wayon.model.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Table(name = "transactions")
@Entity(name = "Transactions")
@Getter
@NoArgsConstructor
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //origen
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private User sender;

    //destino
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private double amount;

    private double fee;

    @Column(name="actual_date")
    private final LocalDateTime  actualDate=LocalDateTime.now();

    @Column(name="desired_date")
    private LocalDateTime desiredDate;

    //logical remotion
    boolean aproved;

    private String text;


    public Transfer(User userSender, User userReceiver, TransferData data,double fee) {
        this.sender=userSender;
        this.receiver=userReceiver;
        this.desiredDate=data.scheduledDate();
        this.aproved=true;
        this.amount=data.amountSend();
        this.fee=fee;
        this.text= data.optionalText();
    }

    public void cancel(String text) {
        this.aproved=false;
        this.text = text;
    }

}
