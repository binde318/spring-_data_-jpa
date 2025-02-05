package com.binde.banking_app.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name ="guardian_name" )
        ),
        @AttributeOverride(
                name="email",
                column = @Column(name = "get_guardian_email")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "get_guardian_mobile")
        )

})
public class Guardian {
    private String name;
    private String email;
    private String mobile;
}
