package com.mycompany.myapp.web.rest;
import com.mycompany.myapp.domain.Team;
import com.mycompany.myapp.repository.TeamRepository;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Team.
 */
@RestController
@RequestMapping("/api")
public class TeamResource {

    private final Logger log = LoggerFactory.getLogger(TeamResource.class);

    private static final String ENTITY_NAME = "team";

    private final TeamRepository teamRepository;

    public TeamResource(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    /**
     * POST  /teams : Create a new team.
     *
     * @param team the team to create
     * @return the ResponseEntity with status 201 (Created) and with body the new team, or with status 400 (Bad Request) if the team has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/teams")
    public ResponseEntity<Team> createTeam(@Valid @RequestBody Team team) throws URISyntaxException {
        log.debug("REST request to save Team : {}", team);
        if (team.getId() != null) {
            throw new BadRequestAlertException("A new team cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Team result = teamRepository.save(team);
        return ResponseEntity.created(new URI("/api/teams/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /teams : Updates an existing team.
     *
     * @param team the team to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated team,
     * or with status 400 (Bad Request) if the team is not valid,
     * or with status 500 (Internal Server Error) if the team couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/teams")
    public ResponseEntity<Team> updateTeam(@Valid @RequestBody Team team) throws URISyntaxException {
        log.debug("REST request to update Team : {}", team);
        if (team.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Team result = teamRepository.save(team);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, team.getId().toString()))
            .body(result);
    }

    /**
     * GET  /teams : get all the teams.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of teams in body
     */
    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        log.debug("REST request to get all Teams");
        return teamRepository.findAll();
    }

    /**
     * GET  /teams/:id : get the "id" team.
     *
     * @param id the id of the team to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the team, or with status 404 (Not Found)
     */
    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable Long id) {
        log.debug("REST request to get Team : {}", id);
        Optional<Team> team = teamRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(team);
    }

    /**
     * DELETE  /teams/:id : delete the "id" team.
     *
     * @param id the id of the team to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/teams/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        log.debug("REST request to delete Team : {}", id);
        teamRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
