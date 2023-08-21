package com.cubedao.cbitcommands;

import com.cubedao.wallet.api.WalletAPI;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;


public class CBITPaymentsCommands extends JavaPlugin {
    private static CBITPaymentsCommands plugin;
    private static WalletAPI wallet;

    public static CBITPaymentsCommands getInstance() {
        return plugin;
    }
    public static WalletAPI getPayments() {
        return wallet;
    }

    public void onEnable() {
        plugin = this;
        wallet = new WalletAPI();

        Objects.requireNonNull(getCommand("createrequest")).setExecutor(new CommandServerRequestCBIT());
        Objects.requireNonNull(getCommand("listrequests")).setExecutor(new CommandListPendingRequests());
        Objects.requireNonNull(getCommand("simulatetx")).setExecutor(new CommandSimulateCBITTransaction());
        Objects.requireNonNull(getCommand("payplayer")).setExecutor(new CommandPayPlayer());
        Objects.requireNonNull(getCommand("listnfts")).setExecutor(new CommandListNFTs());
        Objects.requireNonNull(getCommand("mintnft")).setExecutor(new CommandMintNFT());

        getServer().getPluginManager().registerEvents(new PlayerTransactEventListener(), this);

        getServer().getLogger().info("CBIT Payments Commands enabled!");
    }
}
