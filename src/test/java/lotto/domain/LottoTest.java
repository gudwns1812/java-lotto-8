package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호를_다른_번호와_비교하여_랭크를_반환한다() {
        //given
        Lotto userLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        //when
        Rank rank = userLotto.evaluateRank(otherLotto, bonus);
        //then
        assertThat(rank).isEqualTo(Rank.FIRST_PLACE);
    }

    @Test
    void 로또번호가_5개_보너스_1개는_2등이다() {
        //given
        Lotto userLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 7));
        Lotto otherLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        //when
        Rank rank = userLotto.evaluateRank(otherLotto, bonus);
        //then
        assertThat(rank).isEqualTo(Rank.SECOND_PLACE);
    }
}
