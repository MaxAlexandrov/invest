package com.cryptoinvestment.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Entity Model for one coin.
 * Table "coins"
 *
 * @author maksim aleksandrov
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "coins")
public class Coin implements Serializable {

    /**
     * Id (Embedded)
     * date and name of crypto
     */
    @EmbeddedId
    private CoinKey coinKey;
    /**
     * price of crypto at date
     */
    @Column(name = "price")
    private float price;
}


