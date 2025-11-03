package lotto.config;

public class LottoConfig {
    // 로또 티켓 관련 설정
    public static final long LOTTO_TICKET_PRICE = 1_000L;
    public static final long MIN_TOTAL_BALANCE = 0L;
    public static final long MAX_TOTAL_BALANCE = 1_000_000_000L;

    // 로또 번호 관련 설정
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    // 당첨 등수별 상금
    public static final long FIFTH_PRIZE = 5_000L;
    public static final long FOURTH_PRIZE = 50_000L;
    public static final long THIRD_PRIZE = 1_500_000L;
    public static final long SECOND_PRIZE = 30_000_000L;
    public static final long FIRST_PRIZE = 2_000_000_000L;

    // 당첨 등수별 일치 개수
    public static final int FIFTH_MATCH_COUNT = 3;
    public static final int FOURTH_MATCH_COUNT = 4;
    public static final int THIRD_MATCH_COUNT = 5;
    public static final int SECOND_MATCH_COUNT = 5;
    public static final int FIRST_MATCH_COUNT = 6;

    // 수익률 계산 배율
    public static final double PROFIT_RATE_MULTIPLIER = 100.0;

    private LottoConfig() {
    }
}
