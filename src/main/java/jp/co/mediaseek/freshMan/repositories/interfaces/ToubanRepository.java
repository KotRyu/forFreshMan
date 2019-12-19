package jp.co.mediaseek.freshMan.repositories.interfaces;

import jp.co.mediaseek.freshMan.domains.Touban;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToubanRepository extends JpaRepository<Touban, Integer> {
	List<Touban> findByDeleteflg(String string);
}
