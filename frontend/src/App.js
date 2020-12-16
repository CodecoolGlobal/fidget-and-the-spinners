import React from "react";
import { BrowserRouter as Router, Route } from "react-router-dom";
import "./App.css";
import Login from "./pages/Login";
import Register from "./pages/Register";
import CharacterCreation from "./pages/CharacterCreation";
import Landing from "./pages/Landing";
import Character from "./pages/Character";
import Kitchen from "./pages/Kitchen";
import Copyright from "./components/Copyright";
import styled from "styled-components";
import { StatProvider } from "./contexts/StatProvider";
import { QuestProvider } from "./contexts/QuestProvider";
import Shop from "./pages/Shop";

const Footer = styled.footer`
  width: -webkit-fill-available;
  bottom: 0;
  text-align: center;
  position: fixed;
`;

function App() {
  return (
    <Router>
      <div className="background-image"></div>
      <div className="App">
        <Route exact path="/" component={Landing} />
        <Route exact path="/register" component={Register} />
        <Route exact path="/login" component={Login} />
        <StatProvider>
          <Route
            exact
            path="/username/character-creation"
            component={CharacterCreation}
          />
          <Route path="/character" component={Character} />
          <QuestProvider>
            <Route path="/kitchen" component={Kitchen} />
          </QuestProvider>
          <Route path="/shop" component={Shop} />
        </StatProvider>
        <Footer>
          <Copyright />
        </Footer>
      </div>
    </Router>
  );
}

export default App;
