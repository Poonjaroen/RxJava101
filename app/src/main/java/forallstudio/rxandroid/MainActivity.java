package forallstudio.rxandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("----->", "Clicked Me !!!");
            }
        });
        //justOperator();
        //fromCallableOperator();
        //fromIterableOperator();
        //createOperator();
        //intervalOperator();
        //timeOperator();
        //rangeOperator();
        //repeatOperator();
    }

    public void disposable() {
        Disposable subscribe = Observable.just("1").subscribe();
        Disposable subscribe1 = Observable.just("2").subscribe();

        disposable.add(subscribe);
        disposable.add(subscribe1);

        // cancel subscribe
        disposable.clear();
    }

    public void justOperator() {
        Observable.just(getCustomerNames());
    }

    public void fromCallableOperator() {
        Observable.fromCallable(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                return getCustomerNames();
            }
        });
    }

    public void fromIterableOperator() {
        Observable.fromIterable(getCustomerNames());
    }

    private void createOperator() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                try {
                    for (int i = 0; i < 10; i += 2) {
                        emitter.onNext(String.valueOf(i));
                    }
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });
    }

    private void intervalOperator() {
        Observable.interval(1, TimeUnit.SECONDS);
    }

    private void timeOperator() {
        Observable.timer(5, TimeUnit.SECONDS);
    }

    private void rangeOperator() {
        Observable.range(10, 5);
    }

    private void repeatOperator() {
        Observable.just("Repeat").repeat(5);
    }

    public List<String> getCustomerNames() {
        List<String> customerNames = Arrays.asList(
                "Wasit",
                "Tana",
                "Tanakit",
                "Siwasit",
                "Banyong",
                "Ved",
                "Nantawan",
                "Pawinee",
                "Varut",
                "Ratchanon",
                "Arnon");
        return customerNames;
    }

    public void createObserver() {

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Object o) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        Disposable subscribe = Observable.just("", "")
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                })
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {

                    }
                })
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {

                    }
                })
                .subscribe();

        Observable.just("").subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        Single.just("").subscribe(new SingleObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull String s) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });

        Completable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "";
            }
        }).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });

        Maybe.just("").subscribe(new MaybeObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull String s) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

}