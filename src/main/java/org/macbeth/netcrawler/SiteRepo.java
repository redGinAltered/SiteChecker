package org.macbeth.netcrawler;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepo extends JpaRepository<Site, Long> {

}
