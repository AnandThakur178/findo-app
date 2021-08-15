package net.codejava.Donar;

import javax.persistence.*;

@Entity
@Table(name = "donationtable")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email",nullable = false, unique = true, length = 45)
    private String email;

    @Column(name = "damount", nullable = false, length = 20)
    private String damount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDamount() {
        return damount;
    }

    public void setDamount(String damount) {
        this.damount = damount;
    }
}
