package com.example.ashu.mybank;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    EditText Amount;
    com.gc.materialdesign.views.ButtonRectangle Deposit,withdraw;
    TextView Balance,history;
    BankAccount currentAccount;
    int i = 0;
    int[] array = new int[50];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        currentAccount = new BankAccount();
        Amount = (EditText) findViewById(R.id.amount);
        Deposit = (com.gc.materialdesign.views.ButtonRectangle) findViewById(R.id.deposit);
        withdraw = (com.gc.materialdesign.views.ButtonRectangle) findViewById(R.id.withdraw);
        Balance = (TextView) findViewById(R.id.balance);
        history = (TextView) findViewById(R.id.history);


        Deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                try {
                    String Amount_str = Amount.getText().toString();
                    int amounty = Integer.valueOf(Amount_str);
                    for (int j = 0; j < i; j++) {
                        array[j] = amounty;
                            history.setText("Your recent Transactions :"+ array[j]);
                    }
                    double amount = Double.valueOf(Amount_str);
                    currentAccount.deposit(amount);
                    Balance.setText("Account Balance is : "+currentAccount.getBalance());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });


        withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String Amount_str = Amount.getText().toString();
                    double amount = Double.valueOf(Amount_str);
                    currentAccount.withdraw(amount);
                    Balance.setText("Account Balance is : "+currentAccount.getBalance());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
