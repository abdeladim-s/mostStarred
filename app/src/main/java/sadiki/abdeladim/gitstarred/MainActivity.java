package sadiki.abdeladim.gitstarred;

import android.app.Service;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sadiki.abdeladim.gitstarred.backend.Client;
import sadiki.abdeladim.gitstarred.backend.ServiceInetrface;
import sadiki.abdeladim.gitstarred.model.RepoAdapter;
import sadiki.abdeladim.gitstarred.model.RepoResponse;
import sadiki.abdeladim.gitstarred.model.Repository;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private Repository repository;
    private SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);
        loadData();

        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });
    }

    private void loadData(){
        try{
            ServiceInetrface api = Client.getClient().create(ServiceInetrface.class);
            Call<RepoResponse> call = api.getRepositories();
            call.enqueue(new Callback<RepoResponse>() {
                @Override
                public void onResponse(Call<RepoResponse> call, Response<RepoResponse> response) {
                    List<Repository> items = response.body().getRepositories();
                    recyclerView.setAdapter(new RepoAdapter(getApplicationContext(), items));
                    recyclerView.smoothScrollToPosition(0);
                }

                @Override
                public void onFailure(Call<RepoResponse> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(MainActivity.this, "Error Fetching Data!", Toast.LENGTH_SHORT).show();

                }
            });

        }catch (Exception e){
            Log.d("Error", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }

    }
}
