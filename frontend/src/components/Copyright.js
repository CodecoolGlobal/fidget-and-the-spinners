import Typography from "@material-ui/core/Typography";
import Link from "@material-ui/core/Link";
import "../App.css";

export default function Copyright() {
  return (
    <footer>
      <Typography variant='subtitle1' color='textSecondary' align='center'>
        {"Copyright © "}
        <Link color='inherit'>Fidget and the Spinners</Link>{" "}
        {new Date().getFullYear()}
        {"."}
      </Typography>
    </footer>
  );
}
