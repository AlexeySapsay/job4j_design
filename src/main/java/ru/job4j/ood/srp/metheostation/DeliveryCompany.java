package ru.job4j.ood.srp.metheostation;

/**
 * OCP практика на примере логистической компании
 *
 * @author Alexey Sapsay
 * @version 1.0
 * @since 16.10.2022
 */
public class DeliveryCompany {
    /**
     * получение товара для доставки
     *
     * @return true- подтверждения получения
     */
    public boolean receiveGoods() {
        return false;
    }

    /**
     * расчет кратчайшего расстояния
     *
     * @return результат
     */
    public long calculateShortestWayPoints() {
        return 0;
    }

    /**
     * Уведомление получателя о доставке
     *
     * @return успешное уведомление- true
     */
    public boolean customerNotification() {
        return false;
    }
}
