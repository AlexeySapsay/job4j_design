package ru.job4j.ood.lsp.strategy;

/**
 * LSP практика на примере логистической компании
 * реализация шаблона стратегия
 *
 * @author Alexey Sapsay
 * @version 1.0
 * @since 22.10.2022
 */

public class Client extends Context  implements ConcreteStrategies {

    @Override
    public void execute() {

    }

    @Override
    public Data execute(Data data) {
        return null;
    }
}
