package com.example.registration_service.repository;

import com.example.registration_service.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    Optional<Registration> findByEventIdAndParticipantId(Long eventId, Long participantId);


    @Modifying
    @Transactional
    @Query(value = """
        UPDATE events
        SET available_seats = available_seats - :count
        WHERE id = :eventId AND available_seats >= :count
        """, nativeQuery = true)
    int decreaseAvailableSeats(Long eventId, int count);
}