import React, {useState} from "react";
import ReactDOM from "react-dom";

import Counters from "./Counters.jsx";
import SearchForm from "./SearchForm";
import Repos from "./Repos";

function Github(){
    return (
        <div className="github">
            <h2>Search Github Repos. </h2>
            <SearchForm/>
            <Counters/>
            <Repos/>
        </div>
    )
}
export default Github;