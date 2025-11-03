package lotto.config;

public class ErrorMessage {
    // 구매 금액 관련 에러
    public static final String INVALID_BALANCE_RANGE = "[ERROR] 구매 금액은 0원 이상 10억 이하여야 합니다.";
    public static final String INVALID_BALANCE_UNIT = "[ERROR] 구매 금액은 1000원 단위여야 합니다.";
    public static final String INVALID_BALANCE_FORMAT = "[ERROR] 구매 금액은 숫자여야 합니다.";

    // 로또 번호 관련 에러
    public static final String INVALID_LOTTO_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String INVALID_LOTTO_RANGE = "[ERROR] 로또 번호는 1 이상, 45 이하여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBERS = "[ERROR] 로또 번호는 중복일 수 없습니다.";
    public static final String INVALID_WINNING_NUMBERS_FORMAT = "[ERROR] 당첨 번호는 \"숫자,숫자,숫자,숫자,숫자,숫자\" 형식이어야 합니다.";

    // 보너스 번호 관련 에러
    public static final String INVALID_BONUS_RANGE = "[ERROR] 보너스 번호는 1 이상, 45 이하여야 합니다.";
    public static final String INVALID_BONUS_FORMAT = "[ERROR] 보너스 번호는 숫자여야 합니다.";
    public static final String DUPLICATE_WINNING_AND_BONUS = "[ERROR] 당첨 번호와 보너스 번호는 중복일 수 없습니다.";

    private ErrorMessage() {
    }
}
