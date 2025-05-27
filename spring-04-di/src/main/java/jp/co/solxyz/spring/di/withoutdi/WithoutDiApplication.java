package jp.co.solxyz.spring.di.withoutdi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Bootアプリケーションのメインクラス。
 * コマンドラインランナーとして実行時に指定された処理を行う。
 */
@SpringBootApplication
public class WithoutDiApplication implements CommandLineRunner {

    /**
     * 会社クラス
     */
    private final Company company = new Company();

    /**
     * Spring Bootアプリケーションの実行を開始するメソッド。
     *
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        // Spring Bootの起動
        SpringApplication.run(WithoutDiApplication.class, args);
    }

    /**
     * コマンドライン引数を受け取り、会社クラスの処理を実行するメソッド。
     *
     * @param args コマンドライン引数
     * @throws Exception 実行中に発生する可能性のある例外
     */
    @Override
    public void run(String... args) throws Exception {
        company.run();
    }
}
