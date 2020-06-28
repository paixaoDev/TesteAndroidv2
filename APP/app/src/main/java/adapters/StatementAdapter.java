package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carlosvspaixao.bank.R;

import java.util.List;

import models.CurrencyModel;

public class StatementAdapter extends RecyclerView.Adapter<StatementAdapter.ViewHolder> {

    Context context;
    List<CurrencyModel> currencyModelData;

    public StatementAdapter(Context context, List<CurrencyModel> currencyModelData) {
        this.context = context;
        this.currencyModelData = currencyModelData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_statement_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CurrencyModel currencyModel = currencyModelData.get(position);

        holder.tittle.setText(currencyModel.getTittle());
        holder.description.setText(currencyModel.getDesc());
        holder.date.setText(currencyModel.getDate());
        holder.value.setText(String.valueOf(currencyModel.getValue()));
    }

    @Override
    public int getItemCount() {
        return currencyModelData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tittle, description, date, value;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tittle = itemView.findViewById(R.id.txt_tittle);
            description = itemView.findViewById(R.id.txt_description);
            date = itemView.findViewById(R.id.txt_date);
            value = itemView.findViewById(R.id.txt_value);
        }
    }
}
