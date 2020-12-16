import React, { useState, createContext } from "react";
import { fetchStatsApi } from "../api/apiCalls";

export const StatContext = createContext();

export function StatProvider(props) {
  const [stats, setStats] = useState([]);

  function fetchStats() {
    fetchStatsApi().then((data) => setStats(data.data));
  }

  return (
    <StatContext.Provider value={{ stats, fetchStats }}>
      {props.children}
    </StatContext.Provider>
  );
}
