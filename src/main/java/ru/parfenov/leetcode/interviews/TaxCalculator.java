package ru.parfenov.leetcode.interviews;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.SavepointManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/** Мы проводим технический аудит компании, которая занимается расчетом налогов по контракту для других компаний.
 В компании множество отделов, которые пишут софт и считают налоги для разных компаний и стран.
 Мы заметили, что у каждого отдела своя реализация расчета налогов, свои интерфейсы/классы/тесты, хотя с т.з. бизнеса методика очень похожа.
 Пообщавшись с бизнесом стало понятно, что почти каждый отдел считает налог как base(income) + custom(income), а оставшиеся как base(income) - custom(income),
 где income - сумма налоговой базы компании, base(x) - методика рассчета базового налога, одинаковая для всех отделов, а custom(x) - специфичная часть рассчета каждого отдела.
 В целях приведения кодовой базы к общему виду мы взялись реализовать библиотеку, которая должна позволить унифицировать расчеты для всех отделов.
 Требуется спроектировать и реализовать ее.

 Время на задачу - до 15 минут.
 */

// Реализация отдела Альфа-Банка
class AlphaBankTaxCalculator1 {
    public BigDecimal alphaBankCalculation(double income) {
        return calculateBase(income).add(BigDecimal.valueOf(income * 0.3 / 13));
    }

    private BigDecimal calculateBase(double income) {
        return BigDecimal.valueOf(income * 0.87);
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////

// Реализация отдела Сбера
class TaxCalculatorSber1 {
    public BigDecimal calculateSber(BigDecimal income) {
        var base = income.multiply(BigDecimal.valueOf(0.87));
        var custom = income.multiply(BigDecimal.valueOf(0.1)).add(BigDecimal.valueOf(0.11));
        return base.subtract(custom);
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////

// Решение 1:
public interface TaxCalculator {
    BigDecimal calculateTax(BigDecimal income);
}

class AlphaBankTaxCalculator implements TaxCalculator {
    @Override
    public BigDecimal calculateTax(BigDecimal income) {
        BigDecimal base = income.multiply(BigDecimal.valueOf(0.87));
        BigDecimal custom = income.multiply(BigDecimal.valueOf(0.3 / 13));
        return base.add(custom);
    }
}

class TaxCalculatorSber implements TaxCalculator {
    @Override
    public BigDecimal calculateTax(BigDecimal income) {
        BigDecimal base = income.multiply(BigDecimal.valueOf(0.87));
        BigDecimal custom = income.multiply(BigDecimal.valueOf(0.1)).add(BigDecimal.valueOf(0.11));
        return base.subtract(custom);
    }
}

// Решение 2:
class Main {
    public static void main(String[] args) {
        TaxCalculator2 alphaBankTaxCalculator = income -> {
            BigDecimal base = BigDecimal.valueOf(income.doubleValue() * 0.87);
            BigDecimal custom = BigDecimal.valueOf(income.doubleValue() * 0.3 / 13);
            return base.add(custom);
        };

        TaxCalculator2 sberTaxCalculator = income -> {
            BigDecimal base = income.multiply(BigDecimal.valueOf(0.87));
            BigDecimal custom = income.multiply(BigDecimal.valueOf(0.1)).add(BigDecimal.valueOf(0.11));
            return base.subtract(custom);
        };

        // Пример использования
        BigDecimal income = BigDecimal.valueOf(1000);
        BigDecimal alphaBankTax = alphaBankTaxCalculator.calculateTax(income);
        BigDecimal sberTax = sberTaxCalculator.calculateTax(income);

        System.out.println("Налог по методике Альфа-Банка: " + alphaBankTax);
        System.out.println("Налог по методике Сбера: " + sberTax);
    }
}

@FunctionalInterface
interface TaxCalculator2 {
    BigDecimal calculateTax(BigDecimal income);
}
