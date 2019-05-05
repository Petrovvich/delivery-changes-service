package ru.petrovich.test.dcs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.petrovich.test.dcs.model.enums.Sex;

/**
 * Простое представление клиента со всеми вспомогательными данными и, возможно, ссылками на будущие
 * расширения (адрес проживания, история заказов, документы и т.п.)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    /**
     * PK.
     * Уникальный идентификатор кдиента в бд.
     */
    private Long id;
    /**
     * Фамилия клиента.
     */
    private String last_name;
    /**
     * Имя клиента.
     */
    private String first_name;
    /**
     * Отчество (если есть) клиента
     */
    private String middle_name;
    /**
     * Пол клиента. Подробности см. в {@link Sex}
     */
    private Sex sex;
}
