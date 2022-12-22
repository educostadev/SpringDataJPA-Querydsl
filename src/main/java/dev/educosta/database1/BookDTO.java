package dev.educosta.database1;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
@Table(name = "BTO001_CORE_COLORS", schema = "core")
@Entity(name = "color")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BookDTO {
}
