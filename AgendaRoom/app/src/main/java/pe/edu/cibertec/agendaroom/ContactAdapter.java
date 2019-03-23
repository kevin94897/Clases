package pe.edu.cibertec.agendaroom;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactPrototype> {

    private List<Contact> items;

    public ContactAdapter(List<Contact> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ContactPrototype onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;

        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.prototype_contact, viewGroup, false);
        ContactPrototype contactPrototype = new ContactPrototype(view);

        return contactPrototype;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactPrototype contactPrototype, int position) {
        contactPrototype.tvName.setText(items.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ContactPrototype extends RecyclerView.ViewHolder {
        TextView tvName;

        public ContactPrototype(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
