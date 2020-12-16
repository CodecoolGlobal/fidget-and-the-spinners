import React, { useContext, useEffect } from "react";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import { makeStyles } from "@material-ui/core/styles";
import { StatContext } from "../contexts/StatProvider";

const useStyles = makeStyles({
  table: {
    maxWidth: 650,
  },
});

export default function Stats() {
  const { stats, fetchStats } = useContext(StatContext);
  const classes = useStyles();

  useEffect(() => {
    fetchStats();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  return (
    <TableContainer component={Paper}>
      <Table className={classes.table} aria-label="simple table">
        <TableBody>
          {Object.entries(stats).map((stat) => (
            <TableRow key={stat[0]}>
              <TableCell component="th" scope="row" width="70%" align="left">
                {stat[0]}
              </TableCell>
              <TableCell align="left">{stat[1]}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
