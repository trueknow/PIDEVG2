package tn.esprit.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query("select t from Transaction t where t.account.accountId=:x order by t.dateTransaction desc")
	public Page<Transaction> getTransactions( @Param("x") String code, Pageable pageable);
}


