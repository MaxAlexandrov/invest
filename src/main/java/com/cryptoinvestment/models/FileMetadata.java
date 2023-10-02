package com.cryptoinvestment.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * Entity Model file repository.
 * Keep metadata of file with hash
 *
 * @author maksim aleksandrov
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "file_metadata")
public class FileMetadata {

    @Id
    private String hash;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "processed_timestamp")
    private Date processedTimestamp;
    @Column(name = "size")
    private Long size;
    @Column(name = "last_modified")
    private Date lastModified;
    @Column(name = "creation_date")
    private Date creationDate;
}
