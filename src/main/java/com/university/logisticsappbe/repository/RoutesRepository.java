package com.university.logisticsappbe.repository;

import com.university.logisticsappbe.model.api.StatusCountResponse;
import com.university.logisticsappbe.model.domain.DtoForum;
import com.university.logisticsappbe.model.domain.DtoRoutes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.util.List;

@SqlResultSetMapping(
        name = "StatusCountMapping",
        classes = @ConstructorResult(
                targetClass = StatusCountResponse.class,
                columns = {
                        @ColumnResult(name = "status"),
                        @ColumnResult(name = "statuscount")
                }
        )
)
public interface RoutesRepository extends JpaRepository<DtoRoutes, Long> {
    List<DtoRoutes> findAllByAssignedUserId(Long email);
    List<DtoRoutes> findAllByAssignedUserIdIsNull();

    @Transactional
    @Modifying
    @Query("update ROUTES r set r.assignedUserId = :assignedUserId WHERE r.id = :id")
    int updateRoute(Long id, Long assignedUserId);

    @Transactional
    @Modifying
    @Query("update ROUTES r set r.assignedUserId = null WHERE r.id = :id")
    int updateRouteRemoveAssignedUserId(Long id);

    @Transactional
    @Modifying
    @Query(value = "SELECT r.status, count(r.status) as statuscount " +
            "FROM routes r " +
            "GROUP BY r.STATUS",
            nativeQuery = true)
    List<Object[]> findStatusCounts();


//    UPDATE Customers
//    SET ContactName = 'Alfred Schmidt', City= 'Frankfurt'
//    WHERE CustomerID = 1;
}
