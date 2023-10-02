package com.cryptoinvestment.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * Entity Model primary key.
 *
 * @author maksim aleksandrov
 */
@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoinKey implements Serializable {
    @Column(name = "date")
    private Date dateTime;
    @Column(name = "name")
    private String name;

}
