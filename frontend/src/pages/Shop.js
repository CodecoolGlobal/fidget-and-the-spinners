import { Grid } from "@material-ui/core";
import React from "react";
import CharacterWindow from "../components/CharacterWindow";
import Inventory from "../components/Inventory";
import ShopInventory from "../components/ShopInventory";
import Navbar from "../layout/Navbar";
import { useStyles } from "../StyleComponents";

export default function Shop() {
  const classes = useStyles();

  return (
    <>
      <Navbar />
      <Grid container direction="row" spacing={2} className={classes.appBar}>
        <Grid item xs={6}>
          <CharacterWindow />
        </Grid>
        <Grid item xs={6}>
          <Inventory />
          <ShopInventory />
        </Grid>
      </Grid>
    </>
  );
}
