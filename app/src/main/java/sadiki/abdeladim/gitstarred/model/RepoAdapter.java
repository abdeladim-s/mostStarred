package sadiki.abdeladim.gitstarred.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import sadiki.abdeladim.gitstarred.R;

/**
 * Created by Abdeladim SADIKI on 01/01/2018.
 */

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {

    List<Repository> repositories;
    Context context;

    public RepoAdapter(Context context, List<Repository> repositories) {
        this.context = context;
        this.repositories = repositories;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_repository, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.repoName.setText(repositories.get(position).getRepoName());
        holder.repoDesc.setText(repositories.get(position).getRepoDesc());
        holder.repoOwner.setText(repositories.get(position).getRepoOwner().getName());
        holder.nbOfStars.setText(repositories.get(position).getNbOfStars());

        // using picasso to handel the imageView
        Picasso.with(context)
                .load(repositories.get(position).getRepoOwner().getAvatar())
                .placeholder(R.drawable.loading)
                .into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView repoName, repoDesc, repoOwner, nbOfStars;
        private ImageView avatar;

        public ViewHolder(View view){
            super(view);
            repoName = (TextView) view.findViewById(R.id.repoName);
            repoDesc = (TextView) view.findViewById(R.id.repoDesc);
            repoOwner = (TextView) view.findViewById(R.id.repoOwner);
            nbOfStars = (TextView) view.findViewById(R.id.nbOfStars);
        }
    }
}
