package com.cryptoinvestment.repository;

import com.cryptoinvestment.models.FileMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * File METADATA repository.
 * JPA implementation
 *
 * @author maksim aleksandrov
 */
@Repository
public interface FileMetaDataRepository extends JpaRepository<FileMetadata, Long> {

  /**
   * check if hash already in DB
   * @param hash hash
   * @return value (hash)
   */
  @Query(nativeQuery = true, value = "SELECT hash FROM file_metadata WHERE hash = ?1 LIMIT 1")
  Optional<String> findHash(@Param("hash") String hash);

  /**
   * check if hash is in processed
   * @param hash hash
   * @return boolean
   */
  default boolean isProcessed(final String hash) {
    return findHash(hash).isPresent();
  }
}
