package ru.petrovich.test.dcs.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.petrovich.test.dcs.model.enums.Sex;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Простое представление клиента со всеми вспомогательными данными и, возможно, ссылками на будущие
 * расширения (адрес проживания, история заказов, документы и т.п.)
 */
@Entity
@Getter
@Setter
@Table(name = "client")
@NoArgsConstructor
public class Client {
    /**
     * PK.
     * Уникальный идентификатор кдиента в бд.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Фамилия клиента.
     */
    @Column(name = "last_name")
    private String lastName;
    /**
     * Имя клиента.
     */
    @Column(name = "first_name")
    private String firstName;
    /**
     * Отчество (если есть) клиента
     */
    @Column(name = "middle_name")
    private String middleName;
    /**
     * Пол клиента. Подробности см. в {@link Sex}
     */
    @Column
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Builder
    public Client(String lastName, String firstName, String middleName, Sex sex) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.sex = sex;
    }
}
