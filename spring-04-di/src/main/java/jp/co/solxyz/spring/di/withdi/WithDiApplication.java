package jp.co.solxyz.spring.di.withdi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Bootアプリケーションのメインクラス。
 * コマンドラインランナーとして実行時に指定された処理を行う。
 */
@SpringBootApplication
public class WithDiApplication implements CommandLineRunner {

    /**
     * 会社クラス
     */
    private final Company company;

    /**
     * コンストラクタ
     */
    public WithDiApplication(Company company) {
        this.company = company;
    }

    /**
     * Spring Bootアプリケーションの実行を開始するメソッド。
     *
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {

        SpringApplication.run(WithDiApplication.class, args);
    }

    /**
     * コマンドラインからアプリケーション実行時に呼び出されるメソッド。
     * DIされた会社クラスの動作を実行する。
     *
     * @param args コマンドライン引数
     * @throws Exception 実行中に発生する可能性のある例外
     */
    @Override
    public void run(String... args) throws Exception {
        company.run();
    }

}
