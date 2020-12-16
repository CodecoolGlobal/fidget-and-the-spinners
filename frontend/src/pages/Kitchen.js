import React, { useEffect, useContext } from "react";
import Navbar from "../layout/Navbar";
import Container from "@material-ui/core/Container";
import QuestModal from "../components/QuestModal";
import { QuestContext } from "../contexts/QuestProvider";

export default function Kitchen() {
  const { fetchQuests } = useContext(QuestContext);

  useEffect(() => {
    fetchQuests();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  return (
    <Container component='main' maxWidth='xs'>
      <Navbar />
      <QuestModal />
    </Container>
  );
}
